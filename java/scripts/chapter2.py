import pandas as pd

#시리즈(1차원)

menu = pd.Series(['비빔밥','김치찌개','된장찌개'])
price = pd.Series([10000,9000,8000])

#1차원 시리즈로 만들기

pd.DataFrame({'menu':menu,'price':price})

df = pd.DataFrame({
    '메뉴':['비빔밥','김치찌개','된장찌개'],
    '가격':[10000,9000,8000],
    '원산지':['국내산','국내산','국내산']
})
# dataFrame은 이런 식으로 딕셔너리 형태임.