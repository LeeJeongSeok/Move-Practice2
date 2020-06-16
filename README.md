# Move-Practice2

스네이크 게임을 만들기 전에 필요로한 역량을 키우기 위한 일종의 레벨업 프로젝트이다. (두번째)



## 삽질 기록

- Move-Practice 프로젝트에 이어서 테스트 UI를 만드는 과정에서 마주친 삽질이다.

- pack() : 컨테이너의 크기를 구성 요소 들의 크기로 설정하는 메소드
- paint(Graphics g) : 이 메소드가 사용하면 다른 곳에서 setBackground 메소드를 적용해도 먹히질 않음

### paint(Graphics g)과 paintComponent(Graphics g) 차이점

- paint(Graphics g)는 컴포넌트에 그림을 그리기 위한 것으로 Component 클래스에 정의되어 있어서, 모든 컴포넌트에서 사용할 수 있다.
  awt에서는 Componenet 자신을 그리기 위해서 paint()를 override하여서 사용하였습니다.(awt) 

- paintComponent는 paint 메소드를 좀 더 세분화하여 만든 메소드이다(Swing)

  - paintComponent
  - paintChildren
  - paintBorder

- paint 메소드 실행 주체(JVM)

- paint 메소드가 호출되는 시점 -> awt 스레드에 의해 자동으로 호출뭐시기

  - 처음 화면에 나타날 때(GUI Application이 실행 될 때)
  - 다른 화면에 가려져 있던 부분이 다시 화면에 나타날 때
  - 아이콘화 되어 있다가 원래 크기로 화면에 나타날 때

- repaint() awt 스레드에게 화면을 갱신할 것을 요청한다. awt 스레드는 0.1초마다 확인해서 요청이 있으면 update()를 호출한다

- update() 화면을 지우고 다시 paint()를 호출한다

  ![](https://images.velog.io/images/ljs0429777/post/54b84c73-f651-4f17-8ea1-4ac8f5c1279c/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202020-06-09%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2011.13.22.png)

  ```
  * If this component is a lightweight component, this method
  * causes a call to this component's <code>paint</code>
  * method as soon as possible.  Otherwise, this method causes
  * a call to this component's <code>update</code> method as soon
  * as possible.
  
  paint 메소드의 호출되고, 그렇지 않으면 update 메소드의 호출이 된다
  ```

  

### 뱀 생성하기

- x,y 좌표 값을 배열로 하는 이유

  아직까진 나의 생각이지만 자바 GUI에선 x,y좌표로 컴포넌트들을 배치를 한다. 우리가 그릴려고 하는 뱀도 x,y좌표로 그린다. 하지만 뱀은 사용자 키보드 이벤트에 의해 x,y 좌표 값이 변한다 그렇기에 각 좌표별로 배열을 만들어 이벤트가 감지될때마다 값을 증가 시킨다

- 뱀 생성 코드

  ```java
  private void doDrawing(Graphics g) {
  
      if (true) {
  
          g.drawImage(apple, apple_x, apple_y, this);
  
          for (int i = 0; i < dots; i++) {
              if (i == 0) {
                  g.drawImage(head, x[i], y[i], this);
              }else {
                  g.drawImage(tail, x[i], y[i], this);
              }
          }
      } else {
          System.out.println("doDrawing 실패");
      }
  
  }
  ```

  i의 값이 0인 경우는 뱀의 머리를 의미하기에 분기문을 이용하여 머리부분과 꼬리부분을 나눠서 생성한다.

### 뱀 움직이기

- actionPerformed(ActionEvent e) - ActionEvent가 발생하면 호출

  KeyListener를 구현하여 사용중이기때문에 키보드 이벤트가 발생할때마다 ActionEvent가 발생한다 즉. 키보드 이벤트 값에 따라 변화되는 값들은 ActionEvent 메소드 안에 구현하면 되는 것이다.

- move() - DOT_SIZE (10) 만큼 x,y축으로 움직이기

- actionPerformed 이벤트와 keyListener 이벤트 이슈 처리

### event thread

- AWT은 단일 스레드 모델을 사용하여 작동..
- GUI의 상태를 변경하거나 이벤트 핸들링 하는 코드는 모두 하나의 스레드에서 실행되어야 함
- 화면에 보이는 모든 GUI 객체와 각 객체의 상태 변경에 대한 스레드 안정성을 보장하는 것은 비효율적이기에 단일 스레드 모델을 사용한다

### timer

- initGame() 메소드 안에 timer 객체를 초기화 한 후 start() 메소드를 호출하는 구간이 있다.
- 솔직히 처음에 왜 쓰는지 몰랐음;
- 단일 스레드 때문에 추가적으로 스레드 하나를 더 만들어서 이벤트 처리를 하게끔 함
- event thread와 timer 때문에 시간을 좀 많이 쓴 것 같다. thread 관련되서 조그마한 글을 작성해야 할 듯...



## 짧고 굵은 후기

- event thread 때문에 하루 정도 꽁꽁 싸맸다....하...관련된 테스트 프로젝트랑 TIL 써야겠다..정말 짧고 굵게 다가왔다

