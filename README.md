

# Move-Practice2

스네이크 게임을 만들기 전에 필요한 기술들을 연습하는 프로젝트입니다. - 2

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

  ![repaint()](/Users/jeongseok/Library/Application Support/typora-user-images/스크린샷 2020-06-09 오후 11.10.53.png)

  ```
  * If this component is a lightweight component, this method
  * causes a call to this component's <code>paint</code>
  * method as soon as possible.  Otherwise, this method causes
  * a call to this component's <code>update</code> method as soon
  * as possible.
  
  paint 메소드의 호출되고, 그렇지 않으면 update 메소드의 호출이 된다
  ```

  

### 뱀 움직이기

