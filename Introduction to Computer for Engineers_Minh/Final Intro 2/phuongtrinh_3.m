% 1c
clc, clear

syms x
a = 5, b = 7

y = a^x + b^(1-x)
d = int(y,0,1)

