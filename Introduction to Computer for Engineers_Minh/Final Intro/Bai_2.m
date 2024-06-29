% Bai_2
clc, clear, close all

syms x
f = -6*x^2 + x + 120;
g = -x^3 + 7*x^2 - 10*x + 5;
hold on

% a. Plotting symbolic function
ezplot(f)
ezplot(g)

% b. Find the area
Area = int(f-g,-1,2)
