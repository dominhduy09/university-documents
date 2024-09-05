from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from time import sleep
import pygame
import pyttsx3
import speech_recognition as recognizee

ear = recognizee.Recognizer()
spek = pyttsx3.init()
pygame.init()
curent_data = ""
i = 5

def Q_A():
    with recognizee.Microphone() as mic:
        print("i am listening")
        try:
            ear.adjust_for_ambient_noise(mic) 
            sound= ear.listen(mic, timeout= 4)
            myvoice = ear.recognize_google(sound)
        except:
            return Q_A()
    myvoice = myvoice.split(" ")
    for i in myvoice:
        print(myvoice)
        if (i == "name" or i == "Name"):
            spek.say("my name is smart parking car")
            spek.runAndWait()
            return
        elif (i == "we" or i == "We" or i == "who" or i == "on" or i == "hallway" or i == "off"):
            spek.say("we are son of doctor Hintttttt")
            spek.runAndWait()
            return
    return Q_A()

   
# Thay đổi đường dẫn đến file MP3 của bạn
# Khởi tạo trình duyệt  

driver = webdriver.Chrome()  # Chọn trình duyệt của bạn (Chrome, Firefox, etc.)

# Mở trang web
url = "https://blynk.cloud/dashboard/login"  # Thay thế bằng URL của trang web bạn muốn lấy dữ liệu

driver.get(url)

username_field = driver.find_element(By.ID, "email")  # Thay thế bằng định danh thực tế của trường tên đăng nhập
password_field = driver.find_element(By.ID, "password")

username_field.send_keys("narutopps5@gmail.com")
password_field.send_keys("Blynk@DuckNgM")
password_field.send_keys(Keys.ENTER)
sleep(5)
logout_button = driver.find_element(By.XPATH, "/html/body")
logout_button.click()
driver.implicitly_wait(2)
logout_button = driver.find_element(By.XPATH, "/html/body")
logout_button.click()
pygame.mixer.music.load(rf'C:\Users\ADMIN\Documents\Arduino\Project_introEE\Main\mp3\0004.mp3')
pygame.mixer.music.play()
sleep(3)

while True:
    xpath = "/html/body/div[1]/div/div[1]/div[5]/div/div[2]/div[2]/div[2]/section/section/main/div/div/div[8]/div[2]/div/div/div/div/div/div[2]/div/div[6]/div/div[2]/div/span"
    element = driver.find_element(By.XPATH, xpath)

    # Lấy dữ liệu từ phần tử
    data = element.text
    print("Data from the XPath:", data)
    if data == "5": i = 1
    elif data == "6": i = 2
    elif data == "7": i = 3
    elif data == "8": i = 4
    elif data == "0": i = 5
    elif data == "9": 
        spek.say("Car is not defined")
        spek.runAndWait()

    if data != curent_data:

        pygame.mixer.music.load(rf'C:\Users\ADMIN\Documents\Arduino\Project_introEE\Main\mp3\000{i}.mp3')
        pygame.mixer.music.play()
        curent_data = data
        sleep(3)
    else:
        pygame.mixer.music.load(rf'C:\Users\ADMIN\Documents\Arduino\Project_introEE\Main\mp3\0005.mp3')
        pygame.mixer.music.play()
        while data == curent_data:
            element = driver.find_element(By.XPATH, xpath)

        # Lấy dữ liệu từ phần tử
            data = element.text
        


