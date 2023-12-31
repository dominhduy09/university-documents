clear all; close all; clc;
M = 2;
xi = [1, 3, 4, 6, 9];
yi = [4, 4, 7, 11, 19];

% Find coefficients in polynomial form
p = polyfit(xi,yi,M);
y = polyval(p,xi);
figure
plot(xi,yi,'ok')
hold on; grid on;
plot(xi,y,'-b')

% Use these coefficients with other datas rather than xi
x_new = linspace(0,10,101);
y_new = polyval(p,x_new);
figure
plot(xi,yi,'ok')
hold on; grid on;
plot(x_new,y_new,'-b')