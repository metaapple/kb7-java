# ☕ Java Basic Learning - Day 3 (Array)

`day3`에서는 **배열(Array)** 을 집중적으로 연습합니다.  
`Array1~4.java` 흐름대로 **1차원 배열 → 2차원 배열 → 가변(비정형) 2차원 배열 → 얕은/깊은 복사**를 다룹니다.

---

## 📂 프로젝트 구조

> 일부 마크다운 뷰어에서는 `mermaid`가 안 보여서, **텍스트 그림(ASCII)** 으로 정리했습니다.

```text
day3
└─ src
   └─ array
      ├─ Array1.java  (1차원 배열 / for, for-each)
      ├─ Array2.java  (2차원 배열 리터럴 / 중첩 for)
      ├─ Array3.java  (2차원 배열 new / 가변 길이 2차원 배열)
      └─ Array4.java  (배열 복사: 얕은 복사 vs 깊은 복사(clone))
```

---

## 📝 핵심 개념 요약

### 1) 1차원 배열 기초 (`Array1.java`)

- **특징**
  - **고정 크기**: 한 번 만들면 길이를 바꾸기 어렵습니다.
  - **같은 타입만 저장**: `int[]`에는 `int`만 들어갑니다.
  - **자동 초기화**: `new int[10]`처럼 만들면 기본값 `0`으로 채워집니다.
- **자주 쓰는 문법**
  - **선언/생성**: `int[] a = new int[10];`
  - **리터럴 생성**: `int[] b = {100, 200, 300};`
  - **길이**: `b.length`
  - **반복 출력**: `for`, `for-each`

#### 📌 그림: 1차원 배열 메모리(개념)

```text
[스택(Stack)]                         [힙(Heap)]

jumsu2 (참조 변수)  ───────────────▶   int[] (length = 3)
                                     ├─ [0] = 100
                                     ├─ [1] = 200
                                     └─ [2] = 300
```

---

### 2) 2차원 배열 기본 (`Array2.java`)

- **2차원 배열은 “1차원 배열의 배열”**
  - `int[][] scores`는 “행” 단위로 `int[]`를 여러 개 들고 있는 구조입니다.
- `scores.length`는 **행(row) 개수**
- `scores[i].length`는 **i번째 행의 열(column) 개수**

#### 📌 그림: 2차원 배열 접근(개념)

```text
scores (int[][])
 ├─ scores[0] (int[]) ──▶ scores[0][0], scores[0][1], scores[0][2] ...
 └─ scores[1] (int[]) ──▶ scores[1][0], scores[1][1] ...

※ scores.length       = 행(row) 개수
※ scores[i].length    = i행의 열(column) 개수
```

---

### 3) 가변(비정형) 2차원 배열 (`Array3.java`)

`new int[2][]`처럼 만들면 **행(바깥 배열)만 먼저 만들고**, 각 행의 `int[]`는 나중에 원하는 길이로 채울 수 있습니다.

```java
int[][] scores2 = new int[2][];
scores2[0] = new int[3];
scores2[1] = new int[] {1, 2};
```

#### 📌 그림: 행마다 길이가 다른 2차원 배열

```text
scores2 (int[][])
 ├─ scores2[0] = new int[3]   → [0, 0, 0]
 └─ scores2[1] = new int[2]   → [1, 2]  (예시)
```

---

### 4) 배열 복사: 얕은 복사 vs 깊은 복사 (`Array4.java`)

- **얕은 복사(Shallow copy)**: **주소(참조)만 복사**
  - `int[] num4 = num3;`
  - 두 변수가 **같은 배열**을 가리켜서, 하나를 수정하면 다른 쪽에서도 바뀐 것처럼 보입니다.
- **깊은 복사(Deep copy)**: **새 배열을 만들고 값까지 복사**
  - `int[] num5 = num3.clone();`
  - 서로 다른 배열이므로 수정이 독립적입니다.

#### 📌 그림: 얕은/깊은 복사 차이

```text
[얕은 복사]
num3 ──▶ (같은 배열 A) ◀── num4
  → num3[0] 바꾸면 num4에서도 똑같이 바뀜

[깊은 복사]
num3 ──▶ 배열 B
num5 ──▶ 배열 C  (clone으로 새 배열)
  → num3 바꿔도 num5는 영향 없음
```

---

## 🚀 실행 방법

IntelliJ에서 각 파일을 Run 해도 되고, 터미널에서 아래처럼 실행할 수도 있습니다.

```bash
# 예시: Array1 실행
javac src/array/Array1.java
java -cp src array.Array1
```

---

## ✅ 오늘의 체크리스트

- [ ] `new int[10]` 만들면 왜 0으로 채워질까? (기본값/자동 초기화)
- [ ] `for` vs `for-each`는 언제 각각이 더 편할까?
- [ ] `scores.length` 와 `scores[i].length` 차이를 설명할 수 있나?
- [ ] 얕은 복사/깊은 복사를 코드로 직접 확인해봤나?

