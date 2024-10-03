ERD 설명 :

SpecialClass : 특강에 대한 기본 정보. pk값과 강사, 강의 명을 담고 있음

SpecialClassItem: 강의에 대한 하위 정보. SpecialClass fk, 강의 열리는 날짜, 신청 인원을 담고 있음

SpecialClassInventory: 강의에 대한 정보와 하위 정보를 가져오기 위해 만든 link테이블, 현재 신청 인원을 담고 있음

SpecialEnrolment : 유저가 강의를 신청한 정보

User : 유저 정보를 담은 테이블

<img width="886" alt="Screenshot 2024-10-03 at 11 31 11 PM" src="https://github.com/user-attachments/assets/d030bfb5-d239-4021-afd0-7fb54147d017">
