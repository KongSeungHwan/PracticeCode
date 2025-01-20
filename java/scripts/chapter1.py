listbox = ['감사','행복','사랑','성공','긍정','변화','성장','희망']

#리스트에 있는 값의 수를 출력
print(len(listbox))
#리스트의 첫번째 값 가져오기
print(listbox[0])
#리스트 마지막 값 가져오기
print(listbox[-1])
#리스트에서 처음부터 3번째 값까지 출력
print(listbox[:3])
#리스트에서 마지막에서 2번째 값 가져오기
print(listbox[-2])
#리스트 값 중에서 '행복','사랑' 값인 요소들만 출력
print(listbox[1:3])
#리스트 값 중에서 '변화'->'웃음'으로 변경
listbox[-3] = '웃음'
print(listbox[5])
cols=['name','age','phone']

#cols 리스트에 있는 값들을 반복문을 통해 출력
for col in cols:
    print(col)
listbox2 = [15,46,78,24,56]
#리스트에서 최댓값에서 최솟값을 뺀 결과를 리턴하는 함수를 만들고 실행
def min_max(list):
    return max(list)-min(list)
print(min_max(listbox2))

str_data = "여러분의 합격을 응원합니다."

#문자열 "여러분" -> "당신"으로 변환 후 출력하는 함수 정의 후 호출
def convertStr(str):
    return str.replace("여러분","당신")

print(convertStr(str_data))