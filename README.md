## 문자열 덧셈 계산기 기능 목록

#### ✅ 1. 유효한 요청을 보내면 합을 도출한다.

- [x]  빈 문자열을 입력할 경우 0을 반환
- [x]  숫자 하나를 입력할 경우 해당 숫자를 그대로 반환
- [x]  쉼표와 콜론을 함께 사용하여 숫자들의 합 반환
- [ ]  //와 \n 사이의 문자를 커스텀 구분자로 사용하여 합 반환

#### ❌ 2. 유효하지 않은 요청이라면 예외를 발생한다.
- [ ]  음수가 입력된 경우 IllegalArgumentException 발생
- [ ]  숫자 자리에 문자가 입력된 경우 IllegalArgumentException 발생
- [ ]  입력값이 long 범위를 넘어가는 경우 IllegalArgumentException 발생
- [ ]  계산 결과가 long 범위를 넘어가는 경우 ArithmeticException 발생
- [ ]  //로 시작하지만 \n이 없는 경우 IllegalArgumentException 발생
- [ ]  //와 \n 사이에 구분자가 없는 경우 IllegalArgumentException 발생
- [ ]  커스텀 구분자 자리에 숫자가 입력된 경우 IllegalArgumentException 발생
- [ ]  연속된 구분자가 있는 경우 IllegalArgumentException 발생
- [ ]  구분자만 있고 숫자가 없는 경우 IllegalArgumentException 발생