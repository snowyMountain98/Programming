class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int lastAttack = attacks[attacks.length - 1][0];
		int[] attackTime = new int[lastAttack + 1];
		int continuousS = 0;
		int answer = health;

		for (int i = 0; i < attacks.length; i++)
			attackTime[attacks[i][0]] = attacks[i][1];

		/************************************************************
		 * attacks		: [[2, 10], [9, 15], [10, 5], [11, 5]]
		 * attackTime	: [0, 0, 10, 0, 0, 0, 0, 0, 0, 15, 5, 5]
		 ************************************************************/

		for (int i = 1; i <= lastAttack; i++) {
			if (attackTime[i] != 0) {
				/* 몬스터의 공격을 받으면 정해진 피해량만큼 현재 체력이 줄어듦 */
				answer -= attackTime[i];

				/* 만약 몬스터의 공격을 받고 캐릭터의 체력이 0 이하가 되어 죽는다면 -1을 return */
				if (answer <= 0)
					return -1;

				/* 연속 성공 시간이 0으로 초기화 */
				continuousS = 0;
				continue;
			}

			/* 1초마다 x만큼의 체력을 회복 */
			answer = answer + bandage[1] > health ? health : answer + bandage[1];
			continuousS++;

			/* t초 연속으로 붕대를 감는 데 성공한다면 y만큼의 체력을 추가로 회복 */
			if (continuousS == bandage[0]) {
				answer = answer + bandage[2] > health ? health : answer + bandage[2];
				continuousS = 0;
			}
		}

		return answer <= 0 ? -1 : answer;
	}
}