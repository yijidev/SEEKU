# 클라우드 환경 쿠버네티스 모니터링 서비스
``` 본 프로그램은 과학기술정보통신부 정보통신창의인재양성사업의 지원을 통해 수행한 ICT멘토링 프로젝트 결과물입니다. ``` <br>
### 개발 목적 <br>
---
쿠버네티스 클러스터에서 동작하는 애플리케이션을 관리 하고 Alert 기능을 설정할 수 있다. <br>
컨테이너 환경에 대한 모니터링을 반영하여, 쿠버네티스의 메트릭 정보와 이벤트 정보를 분석하여 공격자를 실시간으로 모니터링한다. <br>
보다 다양한 시각화 기술을 이용하여 잠재적 보안 위협이 될 수 있는 요인들을 직관적으로 확인 고 사전에 효과적으로 차단할 수 있다. <br>

### 주요 기능 <br>
---
쿠버네티스 메트릭 정보를 수집하고 데이터베이스(MariaDB)에 저장하여 보관한다.
- 대시보드에서는 다음과 같은 정보를 확인할 수 있다.
  - 네임스페이스, 디플로이먼트, 레플리카셋, 데몬셋, 스테이트풀셋, 파드의 수
- Alert 페이지(/alert/field)에서는 사용자가 지정한 값을 DB에 저장한다.

### 사용 방법 <br>
---
- 먼저 다음과 같은 정보가 준비되어있어야 한다.
  - 쿠버네티스의 Namespace, Deployment, ReplicaSet, DaemonSet, StatefulSet, Pod의 list, get watch를 허용하는 ClusterRole
  - 해당 ClusterRole과 연결된 ServiceAccount
  - 해당 ServiceAccount의 Secret 토큰값
  - 쿠버네티스 API URL
  - Kubernetes 클러스터의 CA(Certificate Authority) 인증서의 인코딩된 데이터
  - 데이터 값을 저장할 DB 서버의 정보

- KubernetesClientConfig.java에서
  - 쿠버네티스 API URL과 Secret 토큰값, CA값을 설정한다. <br>
- application.properties에서
  - 쿠버네티스 API URL과 토큰 정보를 설정한다.
  - URL, username, password 등 DB서버의 정보를 설정한다. <br>

자바 프로젝트를 빌드하여 실행하고, localhost의 8080 포트로 접속한다.

### 사용한 OS <br>
---
Windows 10, Ubuntu, Amazon Linux2
