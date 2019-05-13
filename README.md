# study-jpa

jpa 실습 예제 기록 with 최범균's JPA프로그래밍 입문

#### 실행순서

1. download ojdbc7 and put it into your build path.
2. create table named 'MEMBER'

#### entity 클래스

- 테이블과 매핑되는 클래스
- @Entity 어노테이션을 붙인다.

#### persistence context : 영속 컨텍스트

- A Set of jpa과 관리하는 엔티티 객체들
- 앱과 db 사이에 매개자 역할이다.
- app can't access directly to persistence context
- 영속 컨텍스트는 세션 단위로 생긴다
- 세션? = Entity Manager
- 세션 생길때 pc 생성, 소멸시 pc 소멸
- 영속 객체 = pc속에 보관된 객체

#### entity manager

- factory로 부터 구한다
- 기본

```JAVA
EM.find(User.class, user.getEmail());
EM.persist(user);
EM.remove(user);
```

#### dirty checking

- 트랜잭션 종료 시 pc에 존재하는 영속 객체들 값이 변경되었는지 check한다. 변경되었다면 update 시켜버림.

#### jpa 프로바이더

- 하이버네이트가 그 한 종류다.
- 하이버네이트는 매핑정보를 읽고, 적절한 쿼리를 생성시켜준다.
