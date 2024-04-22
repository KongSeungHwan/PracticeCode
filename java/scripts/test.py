from transformers import AutoTokenizer, AutoModelForCausalLM

# 모델 및 토크나이저 로드
tokenizer = AutoTokenizer.from_pretrained("skt/ko-gpt-trinity-1.2B-v0.5")
model = AutoModelForCausalLM.from_pretrained("skt/ko-gpt-trinity-1.2B-v0.5")

# 대화형 텍스트 생성 함수 정의
def interactive_generate():
    while True:
        # 사용자 입력 받기
        print("종료하고 싶으면 '종료'라고 입력해주세요")
        prompt = input("You: ")

        # 프롬프트가 "종료"인 경우 프로그램 종료
        if prompt == "종료":
            print("Goodbye!")
            break

        # 프롬프트를 기반으로 텍스트 생성
        input_ids = tokenizer.encode(prompt, return_tensors="pt")
        output = model.generate(input_ids, max_length=150, do_sample=True, pad_token_id=tokenizer.eos_token_id, num_return_sequences=1)

        # 생성된 텍스트 출력
        for ids in output:
            generated_text = tokenizer.decode(ids, skip_special_tokens=True)
            print(generated_text)

# 대화형 텍스트 생성 함수 호출
interactive_generate()
