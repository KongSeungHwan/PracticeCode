import pandas as pd
import numpy as np

l = {"a":[1,2,np.nan,4,5,6,7,np.nan,9,1000,2000],"c":[1,3,5,6,7,8,9,11,13,15,17]}
test = {"a":[1,3,5,7,9,1,4],"c":[1,3,5,6,7,8,9]}

df = pd.DataFrame(l)

# 결측값 중앙값으로 대체
df["a"].fillna(int(df["a"].median()))

# 이상치 10으로 대체
df["a"] = df["a"].apply(lambda x: x if x<=10 else 10)
df["b"] = df["a"].apply(lambda x: x ** 2 if x <= 10 else 10 ** 2)
df["d"] = df["c"].apply(lambda x: x+1)
# 모델 파일 로드

from sklearn.ensemble import RandomForestClassifier

model = RandomForestClassifier()

model.fit(df.drop("b",axis=1).drop("d",axis=1),df.drop("a",axis=1).drop("c",axis=1))

result = pd.DataFrame(model.predict(pd.DataFrame(test)),columns=["a","c"]).astype(int)
print("a list:")
print(test["a"])
print("c list:")
print(test["c"])
print(result)



