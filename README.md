# 소프트웨어 공학 - Mission 2

**B995103 은혜민 C011139 이민경 C035384 정세린**

### **1. 역할 분담**

- search_bs() : 이민경
- junit test : 은혜민
- performance test : 정세린

### **2. Jenkins CI/CD 구동 아웃풋 로그**

![스크린샷 2024-06-15 174750](https://github.com/alsrudursla/Software-Engineering/assets/90559205/5dd9a123-4b69-4eea-a217-419dd590c7c3)

```
Started by user admin
Obtained SW/Jenkinsfile from git https://github.com/alsrudursla/Software-Engineering.git/
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in C:\ProgramData\Jenkins\.jenkins\workspace\Hongik
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Checkout SCM)
[Pipeline] checkout
The recommended git tool is: NONE
using credential Hongik-Test
 > git.exe rev-parse --resolve-git-dir C:\ProgramData\Jenkins\.jenkins\workspace\Hongik\.git # timeout=10
Fetching changes from the remote Git repository
 > git.exe config remote.origin.url https://github.com/alsrudursla/Software-Engineering.git/ # timeout=10
Fetching upstream changes from https://github.com/alsrudursla/Software-Engineering.git/
 > git.exe --version # timeout=10
 > git --version # 'git version 2.45.1.windows.1'
using GIT_ASKPASS to set credentials Hongik-Test
 > git.exe fetch --tags --force --progress -- https://github.com/alsrudursla/Software-Engineering.git/ +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git.exe rev-parse "refs/remotes/origin/master^{commit}" # timeout=10
Checking out Revision 6de3618067dd2e226926f47359c732578f9279e4 (refs/remotes/origin/master)
 > git.exe config core.sparsecheckout # timeout=10
 > git.exe checkout -f 6de3618067dd2e226926f47359c732578f9279e4 # timeout=10
Commit message: "update Jenkinsfile"
 > git.exe rev-list --no-walk 76f4e12d23f67678bb74c3e1ee585883480200e8 # timeout=10
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Checkout)
[Pipeline] checkout
The recommended git tool is: NONE
using credential Hongik-Test
 > git.exe rev-parse --resolve-git-dir C:\ProgramData\Jenkins\.jenkins\workspace\Hongik\.git # timeout=10
Fetching changes from the remote Git repository
 > git.exe config remote.origin.url https://github.com/alsrudursla/Software-Engineering.git/ # timeout=10
Fetching upstream changes from https://github.com/alsrudursla/Software-Engineering.git/
 > git.exe --version # timeout=10
 > git --version # 'git version 2.45.1.windows.1'
using GIT_ASKPASS to set credentials Hongik-Test
 > git.exe fetch --tags --force --progress -- https://github.com/alsrudursla/Software-Engineering.git/ +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git.exe rev-parse "refs/remotes/origin/master^{commit}" # timeout=10
Checking out Revision 6de3618067dd2e226926f47359c732578f9279e4 (refs/remotes/origin/master)
 > git.exe config core.sparsecheckout # timeout=10
 > git.exe checkout -f 6de3618067dd2e226926f47359c732578f9279e4 # timeout=10
Commit message: "update Jenkinsfile"
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Build)
[Pipeline] bat

C:\ProgramData\Jenkins\.jenkins\workspace\Hongik>javac -cp "C:/Users/alsrud/eclipse/jee-2024-03/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar;SW/src" -encoding UTF-8 -d classes SW/src/BookManagerTest3.java 
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Test)
[Pipeline] script
[Pipeline] {
[Pipeline] bat

C:\ProgramData\Jenkins\.jenkins\workspace\Hongik>java -cp classes;lib;C:/Users/alsrud/eclipse/jee-2024-03/eclipse/plugins/junit-platform-console-standalone-1.7.1.jar org.junit.platform.console.ConsoleLauncher --scan-classpath  1>final_result.txt 
[Pipeline] }
[Pipeline] // script
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Declarative: Post Actions)
[Pipeline] archiveArtifacts
Archiving artifacts
[Pipeline] echo
Build and test succeeded
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```

### **3. 에러 메시지**

**3-1. Git 오류**

![image](https://github.com/alsrudursla/Software-Engineering/assets/90559205/3023fb16-6f8a-4036-acd7-e6b04a6c7531)

- performance_test branch에서 이전 commit 기록을 확인한 후 git reset HEAD^ —hard를 통해 commit을 취소하기 위해 git log origin/performance_test..HEAD를 실행했으나, 위의 에러가 발생.
- git fetch origin을 실행한 후 위의 command를 다시 실행하니 에러가 발생하지 않음.

![image](https://github.com/alsrudursla/Software-Engineering/assets/90559205/2dbf0b62-26c9-4d83-b005-7398a0f5a918)

- master에서 BookManager.java를 변경 후 commit하였고, performance_test에서도 같은 file을 변경 후 commit한 상태에서 merge를 시도하여 위의 에러 발생.
- 해당 file에서 conflict를 resolve한 후 다시 pull request, merge를 수행하니 에러가 발생하지 않음.

**3-2. Jenkins 오류**

```
java.io.IOException: CreateProcess error=2, 지정된 파일을 찾을 수 없습니다
```

- Jenkins 빌드 중 발생한 오류
- 윈도우 환경에서는 ‘sh’ 대신 ‘bat’ 명령어를 사용하며 문제 해결

**3-3. Git-Jenkins 연동 오류**

```
Failed to connect to repository : Command "git.exe ls-remote -h -- https://github.com/alsrudursla/Software-Engineering.git HEAD" returned status code 128: stdout: stderr: fatal: unable to access 'https://github.com/alsrudursla/Software-Engineering.git/': error setting certificate file: C:/Program Files/Git/mingw64/ssl/certs/ca-bundle.crt
```

- Jenkins 에서 Git Repository 연동 중 발생한 오류
- ca-bundle.crt 파일이 위치한 경로를 찾은 후, 관리자 권한으로 cmd 창을 열어 C:\Program Files\Git\etc\gitconfig 파일에서 http.sslcainfo 값 원하는 경로로 수정하며 해결

**3-4.  Git-Eclipse 연동 오류 해결**

- 이클립스 메뉴 File->Import->Git에서 Projects from Git (with smart import)를 누른다
- Clone URI를 누르고 URI에 팀프로젝트 깃허브 레파지토리 주소를 복사하여 붙여넣는다
- 해당 순서가 끝난 이후 프로젝트를 open하여 팀프로젝트를 진행한다
