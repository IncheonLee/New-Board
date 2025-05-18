📄 README.md
markdown
복사
편집
# 🌟 오늘의 운세 (Fortune Today)

간단한 한 줄의 운세를 매일 랜덤으로 보여주는 Spring Boot 기반의 웹 서비스입니다.  
Thymeleaf 템플릿을 활용해 사용자에게 따뜻한 메시지를 전달합니다.

<br/>

## 🛠️ 기술 스택

- **Backend**: Java 17, Spring Boot 3.1.0, Spring MVC, Spring Data JPA
- **Database**: H2 In-Memory DB (`schema.sql`, `data.sql` 기반 초기화)
- **View**: Thymeleaf (HTML 템플릿)
- **Build Tool**: Gradle
- **Infra**: Embedded Tomcat, H2 Console
- **Etc.**: Lombok, Git

<br/>

## 📌 주요 기능

- 💬 메인 페이지에서 랜덤 운세 한 줄 출력
- 🔁 [다시 뽑기] 버튼으로 운세 새로고침
- 🧠 운세 데이터를 `H2` DB에서 불러와 출력
- 🔍 `/api/fortune` 엔드포인트로 JSON 형태 운세 제공
- 📋 DB 초기화: `schema.sql` + `data.sql` 자동 실행

<br/>

## 📸 미리보기

> [http://localhost:8080](http://localhost:8080)

![screenshot](https://user-images.githubusercontent.com/your-screenshot.png)
> ✨ 브라우저에서 보여지는 운세 화면 예시 (추후 추가 가능)

<br/>

## 🧪 실행 방법

```bash
# 프로젝트 클론
git clone https://github.com/IncheonLee/fortune-today.git
cd fortune-today

# 빌드 & 실행
./gradlew bootRun

# 또는 IntelliJ로 열어서 FortuneTodayApplication 실행
접속: http://localhost:8080

H2 Console: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb

<br/>
⚙️ 향후 개선 아이디어
 ✍ 사용자 이름 기반 운세 고정 로직

 📝 운세 추가/삭제를 위한 관리자 페이지

 💾 H2 → MySQL로 전환 후 실 배포 환경 구성

 🌐 포트폴리오 사이트에 연동 or 퍼블릭 서비스로 배포

<br/>
🙋‍♂️ 개발자
이름	GitHub	기술블로그
이준석	@IncheonLee	- (준비 중)

💬 문의
궁금한 점이나 제안하고 싶은 아이디어가 있다면 GitHub Issue 또는 PR로 남겨주세요!
