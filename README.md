# 스프링 입문 - 회원 관리 서비스

---
## 2026-01-07

### Key Concepts
- **Dependency Injection (DI)**: 컴포넌트 스캔과 자동 의존관계 설정 및 자바 코드로 직접 스프링 빈을 스프링 컨테이너에 등록하는 법. 기존 코드를 손대지 않고 설정만으로 구현 클래스를 변경 가능
- **JDBC**: 메모리 휘발성 문제를 해결하고 DB와 상호작용 하여 데이터 영속성을 확보
- **Open-Closed Principle**: 확장가능, 수정 및 변경은 불가
- **통합 테스트**: 스프링 컨테이너를 사용하는 테스트 기법, 가능하면 **단위 테스트**를 구현하는 편이 낫다
- **JDBC Template**: JDBC를 쉽게 사용할 수 있게 해주는 라이브러리

### Deep Dive
- `@PostMapping()`: @GetMapping() 과 달리 정보를 넘길 때 사용
- `@Transactional`: 테스트 케이스에 있으면 테스트 시작 전에 트랜잭션을 시작, 완료 후 롤백해 DB에 데이터를 남기지 않음

---
## 2026-01-06

### Key Concepts
- **Controller - Service - Repository - Domain**: 계층 분리를 통한 역할 분담
- **JUnit 5**: `assertThrows`, `assertThat`, `@AfterEach`등을 이용한 테스트

### Deep Dive
- `Optional<>`: Null 방지
- `.get()`: Optional 내부 객체 리턴
- `.ifPresent()`: Optional 내부 안전 확인
- `() ->`: 파라미터 없이 람다식 실행