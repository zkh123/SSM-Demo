# -*- coding: utf-8 -*-  
from selenium import webdriver
 
 
def main():
    url = 'https://www.tianyancha.com/login'
    driver = webdriver.Chrome()
    driver.get(url)
if __name__ == '__main__':
    print('java 调用有第三方库的python脚本成功')
    main()
