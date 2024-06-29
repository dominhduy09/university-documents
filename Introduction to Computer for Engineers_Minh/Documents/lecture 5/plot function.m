clear all
close all
clc

%plot function
x= -2:0.01:2;
% define function
fano = @(x) (x.^3-3*x+1));
y =fano(x);
a=-2;
b=2;

%plotting
plot(x,y,'r--',"linewidth",6)
axis([-2 2 -2 6])
grid on
title('Nguyen Dao Anh Khoi - Function {f_1(x) =x^3-3*x+1}')
ylabel("y axis (unit)")
xlabel("x axox (unit)")

