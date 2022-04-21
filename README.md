# 놀이공원 발권 프로그램 (SimpleTicketingSystem)
##### Updated : 2022-04-22 
롯데월드 입장권을 참고하여 구성하였으며, 사용자가 개인정보와 입장권의 종류, 수량, 우대 사항을 입력하면 해당 내역을 반영하여 최종 가격을 출력해주는 프로그램입니다.   

## 주요 기능
 - 입력 기능 ( Keyboard / .csv File )
 >키보드 입력 시 권종, 이용시간, 주민등록번호, 수량, 우대사항을 입력합니다.
 .csv 파일을 통한 입력 시  권종, 이용 시간, 주민등록번호, 수량, 우대 사항 순으로 파일에서 정보를 읽어옵니다.
 
 - 출력 기능 ( CMD / .txt File )
 > 콘솔창에서 사용자가 입력한 발권내역을 확인할 수 있습니다.
 > Result.txt 파일을 생성하여 사용자가 입력한 발권내역을 저장합니다.
 - 계산 기능 
 > 사용자가 입력한 주민등록번호를 바탕으로 만 나이를 계산하여 해당 나이의 요금제를 부여합니다.
 > 사용자가 입력한 우대 사항을 반영하여 할인율을 적용합니다.
 > 다수의 발권내역의 총 금액을 확인할 수 있습니다.
 
## 사용한 Class에 대한 설명
- Main 
> TicketSystem 객체를 생성하고, 프로그램의 시작과 종료를 담당합니다.
- TicketingSystem
>  사용자 입력 정보를 저장하는 List와 TicketInfo, Input, Print, Calculate 객체를 생성합니다.
>  프로그램의 구동 절차를 정의하고, 제어합니다.
>  TicketInfo 객체의 정보를 List에 저장합니다.
- ConstantData 
> 프로그램에서 사용하는 상수 값을 정의합니다.
- TicketInfo
> 발권시 필요한 정보를 인자로 정의하며, 각각의 인자에 대한  getter()와 setter() Method를 제공합니다.
- Input
> 사용자의 입력을 처리하며, TicketInfo 객체에 해당 정보를 저장합니다.
> 프로그램의 분기별 사용자의 입력을 처리합니다.
> .csv 파일을 읽어서 List에 저장합니다.
- Calculate
> TicketInfo 객체의 정보를 받아서 나이 별 요금제를 계산합니다. 
> 우대 사항에 대한 할인율을 계산합니다.
> 총 금액 및 각각의 발권 금액을 계산합니다.
 - Print
 > TicketInfo가 저장된 List를 받아와서 발권 내역을 콘솔 화면에  출력합니다.
 > Result.txt 파일에 발권 내역을 저장합니다.
 
 ## 프로그램 구동 화면
 - .csv 파일 입력
 >.csv file sample 
 <img width="300" alt="sample_CSVFILE" src="https://user-images.githubusercontent.com/102117360/164531692-8c0ceb71-1ad7-49ae-aee7-5100b967855e.png">
> 프로그램 구동 화면
<img width="418" alt="inputCSV" src="https://user-images.githubusercontent.com/102117360/164535006-813c23bc-7ff6-444d-ac05-9bbb0dcfa43c.png">
 > Result.txt 파일 저장
<img width="371" alt="result" src="https://user-images.githubusercontent.com/102117360/164531719-4f12d176-0e84-4b00-b1b6-df558e67c8ea.png">
 
 - 키보드 입력
> 프로그램 구동 화면
<img width="407" alt="keyboard" src="https://user-images.githubusercontent.com/102117360/164535014-34e04378-eefe-4013-831b-5aac6031bec8.png">
>Result.txt 파일 저장
<img width="358" alt="result2" src="https://user-images.githubusercontent.com/102117360/164535016-dc6e0981-e342-462e-9b3f-de8a62e3a92a.png">
