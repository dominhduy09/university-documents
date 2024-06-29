% Bai_5
clc
clear
close all

h=[0 1.7 1.9 2.6 2.9 4 5.2];
F=[0 2.6 3.6 4.3 6.2 11.5 30.6];

% a. Compute the best fit for 2nd degree
% polynomial (quadratic) for the above data.
p=polyfit(h,F,2)

% b. Plot actual data and fit mode
hold off
hold on
plot(h,F,'o');
xi = linspace(0,14,100);
yi = polyval(p, xi);
title('DoMinhDuy-ITITSB22029 Problem 2.b')
plot(xi,yi);

% c. Calculate the sum of the squares of the
% errors of this model. Calculate the
% flow rate for following heights of level of water
Ffit=polyval(p, h);
Error =sum((F-Ffit).^2)

F8m=polyval(p,8)
F10m=polyval(p,10)
F14m=polyval(p,14)

