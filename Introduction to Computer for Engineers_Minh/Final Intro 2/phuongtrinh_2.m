% 1b
clc, clear

syms x
a = 5;
o = 1;
u = 0;
y = 1 / (sqrt(2*pi*o^2) * exp(-(x-u)^2)/(2*o^2))
double (int(y,-a,a))
