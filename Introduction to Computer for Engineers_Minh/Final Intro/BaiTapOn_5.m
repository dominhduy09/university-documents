% 3

clc, clear, close all
syms x
y1 = x
y2 = (1/6)*x^2

% a. Plot 2 line
title('DoMinhDuy-ITITSB22029 Problem 3.a');
hold off
hold on
ezplot(x,y1)
ezplot(x,y2)

% b. Calculate the area of the region
% bounded  by the y1 and y2
y3 = (1/6)*x^2 - x
root  = solve(y3)
Area = int ((y1 - y2), root(1), root(2))
