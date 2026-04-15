# KB7-java

**Java String 클래스**에서 가장 자주 사용되고 중요한 메서드 **10개**
<hr>

| 순위 | 메서드 | 설명 | 반환 타입 | 예시 |
|------|--------|------|----------|------|
| 1 | `length()` | 문자열의 길이를 반환 | `int` | `"Hello".length()` → 5 |
| 2 | `charAt(int index)` | 특정 위치의 문자 1개 반환 | `char` | `"Hello".charAt(1)` → 'e' |
| 3 | `substring(int beginIndex)`<br>`substring(int beginIndex, int endIndex)` | 문자열 일부를 잘라서 반환 | `String` | `"HelloWorld".substring(5)` → "World"<br>`"HelloWorld".substring(0,5)` → "Hello" |
| 4 | `equals(Object obj)` | 문자열 내용이 같은지 비교 (대소문자 구분) | `boolean` | `"java".equals("Java")` → false |
| 5 | `equalsIgnoreCase(String anotherString)` | 대소문자 구분 없이 비교 | `boolean` | `"java".equalsIgnoreCase("Java")` → true |
| 6 | `indexOf(String str)` | 특정 문자열이 처음 등장하는 위치 반환 | `int` | `"Hello World".indexOf("World")` → 6 |
| 7 | `contains(CharSequence s)` | 특정 문자열을 포함하고 있는지 확인 | `boolean` | `"Hello".contains("ell")` → true |
| 8 | `replace(CharSequence target, CharSequence replacement)` | 문자열 치환 | `String` | `"Hello World".replace("World", "Java")` → "Hello Java" |
| 9 | `trim()` | 양쪽 공백 제거 | `String` | `"  Hello  ".trim()` → "Hello" |
| 10 | `split(String regex)` | 정규식 기준으로 문자열을 배열로 분리 | `String[]` | `"apple,banana,orange".split(",")` → ["apple", "banana", "orange"] |

### 자주 쓰이는 추가 메서드
- `toUpperCase()` / `toLowerCase()` : 대문자/소문자 변환
- `startsWith()` / `endsWith()` : 시작/끝 문자열 확인
- `isEmpty()` / `isBlank()` (Java 11+) : 빈 문자열 확인
- `strip()` (Java 11+) : trim()보다 강력한 공백 제거

