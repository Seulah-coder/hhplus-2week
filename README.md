# 항해 2주차

### TDD & 클린아키텍처

![image](https://github.com/user-attachments/assets/ef36439d-db69-411f-af19-4d1b705992ea)

- 애플리케이션의 핵심은 비즈니스 로직
- 데이터 계층 및 API 계층이 비즈니스 로직을 의존 ( 비즈니스의 Interface 활용 )
- 도메인 중심적인 계층 아키텍처
- Presentation 은 도메인을 API로 서빙, DataSource 는 도메인이 필요로 하는 기능을 서빙

### **`Default`**

- 아키텍처 준수를 위한 애플리케이션 패키지 설계
- 특강 도메인 테이블 설계 및 목록/신청 등 기본 기능 구현
- 각 기능에 대한 **단위 테스트** 작성

> 사용자 회원가입/로그인 기능은 구현하지 않습니다.
> 

### **`STEP 3`**

- 설계한 테이블에 대한 **ERD** 및 이유를 설명하는 **README** 작성
- 선착순 30명 이후의 신청자의 경우 실패하도록 개선
- 동시에 동일한 특강에 대해 40명이 신청했을 때, 30명만 성공하는 것을 검증하는 **통합 테스트** 작성

### **`STEP 4`**

- 같은 사용자가 동일한 특강에 대해 신청 성공하지 못하도록 개선
- 동일한 유저 정보로 같은 특강을 5번 신청했을 때, 1번만 성공하는 것을 검증하는 **통합 테스트** 작성

---

- 구현한 내용 ERD 설명 :

#### - SpecialClass : 특강에 대한 기본 정보. pk값과 강사, 강의 명을 담고 있음

#### - SpecialClassItem: 강의에 대한 하위 정보. SpecialClass fk, 강의 열리는 날짜, 신청 인원을 담고 있음

#### - SpecialClassInventory: 강의에 대한 정보와 하위 정보를 가져오기 위해 만든 link테이블, 현재 신청 인원을 담고 있음

#### - SpecialEnrolment : 유저가 강의를 신청한 정보

#### - User : 유저 정보

~~이제와서 생각해보면 자바에서 Class가 어마 무시하게 많이 쓰이기 때문에 특강이라도 Class를 안쓰고 lecture로 사용한게 더 나았을거 같다..~~

<img width="886" alt="Screenshot 2024-10-03 at 11 31 11 PM" src="https://github.com/user-attachments/assets/d030bfb5-d239-4021-afd0-7fb54147d017">
