from transformers import AutoTokenizer, AutoModelForCausalLM

# 모델과 토크나이저 로드
tokenizer = AutoTokenizer.from_pretrained("meta-llama/Meta-Llama-3-70B")
model = AutoModelForCausalLM.from_pretrained("meta-llama/Meta-Llama-3-70B")

# 대화 생성 함수
def generate_response(prompt, max_length=100):
    input_ids = tokenizer.encode(prompt, return_tensors="pt")

    # 모델에 입력 전달하여 응답 생성
    output = model.generate(input_ids, max_length=max_length, pad_token_id=tokenizer.eos_token_id)

    # 생성된 텍스트 디코딩
    response = tokenizer.decode(output[0], skip_special_tokens=True)

    return response

def main():
    print("Meta-Llama-3-8B 대화 봇입니다. 대화를 시작해주세요! (종료하려면 '그만'을 입력하세요)")
    while True:
        user_input = input("사용자: ")
        if user_input == "그만":
            print("대화를 종료합니다. 안녕히 가세요!")
            break
        response = generate_response(user_input)
        print("봇:", response)

if __name__ == "__main__":
    main()
