% Bai_3
clc, clear, close all

v=1;
u=0;
syms x

d=(1/(sqrt(2*pi*v))*exp(-((x-u)^2)/2*1));

% a. Find integration d
da=int(d,x)

% b. Ploting symbolic function
ezplot(da,[-5 5])
title('DoMinhDuy-ITITSB22029 Problem 3.b')

% c.	What is the value of
% d when a and b equal to -30 and 50, respectively
dxx=int(d,x,-30,50);
dc=double(dxx)

