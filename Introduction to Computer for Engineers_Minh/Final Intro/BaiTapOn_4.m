% 2. Calculate the flow of water through a culvert
% is difficult. The reason is the flow channel is not
% uniform.

clc, clear, close all

h = [0 1.7 1.95 2.60 2.92 4.04 5.24];
F = [0 2.6 3.6 4.03 6.45 11.22 30.61];

% a. Compute the best fit for 2nd degree polyminal
% (quadratic) for the above data.
% Print out the coefficient of polynomials. The
% output on command windows should be:
p = polyfit(h,F,2)


% b. Plot actual data and all fit polynomials
% (1st, 2nd, 3rd) on the same graph. Clearly indicate
% the degrees on the labels
hold off
hold on
plot(h, F, 'o');
xi = linspace(0,12,100);
yi = polyval(p, xi);
plot (xi,yi);
title('DoMinhDuy-ITITSB22029 Problem 2.b');


% c. Calculate the sum of the squares of the erros of
% this model. Calculate the flow rate for following
% hights of level of water
Ffit = polyval(p, h);
Error = sum((F-Ffit).^2)

F7m = polyval(p, 7)
F10m = polyval(p, 10)
F12m = polyval(p, 12)
