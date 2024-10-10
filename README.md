### LectureCoreStoreRepository의 의존성 설계 포인트:

#### 직접적인 의존성:

`LectureJpaRepository`: JPA 기본 CRUD 작업을 위한 레포지토리
`LectureCustomRepository`: QueryDSL을 사용한 복잡한 쿼리 수행을 위한 레포지토리
`LectureMapper`: 도메인 객체와 엔티티 간의 변환을 담당


#### 간접적인 의존성:

`LectureEntity`: JPA 엔티티 클래스
`Lecture`: 도메인 모델


#### 계층 구조:


```
Domain Layer           Infrastructure Layer
     |                         |
LectureStoreRepository (I/F)   |
     |                         |
     +-------------------------|
                              |
                    LectureCoreStoreRepository (Impl)
                              |
                    LectureJpaRepository (JPA)
                    LectureCustomRepository (QueryDSL)
                    LectureMapper
                    LectureEntity

```


#### 의존성 주입 이유:

`LectureJpaRepository`: 기본적인 CRUD 작업 수행
`LectureCustomRepository`: 복잡한 쿼리나 커스텀 쿼리 수행
`LectureMapper`: 도메인 객체와 엔티티 간의 변환 담당


#### 장점:

도메인 계층과 인프라 계층의 명확한 분리
JPA와 QueryDSL의 기능을 모두 활용 가능
도메인 객체의 순수성 유지
테스트 용이성 (각 컴포넌트를 독립적으로 테스트 가능)
