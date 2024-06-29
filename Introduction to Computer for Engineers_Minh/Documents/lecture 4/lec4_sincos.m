% Taylor Series
% Date
% Calculate the expansion Taylor series ofcos(x) by using Vectorization met

close all
clear all
clc

N= 100;
n= 0:1:100;

##S = sum((-1).^n.*(pi/3).^(2*n+1)./factorial(2*n+1))
##S = sum((pi/3).^(n)./factorial(n))
S = sum((-1).^n.*(pi/3).^(2*n)./factorial(2*n+1))
disp("Nguyễn Đào Anh Khôi");

