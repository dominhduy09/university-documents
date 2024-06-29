%2

clc, clear, close all

h = [0 1.7 1.95 2.60 2.92 4.04 5.24];
F = [0 2.6 3.6 4.03 6.45 11.22 30.61];

%a
p = polyfit(h,F,2)

%b
hold off
hold on
plot(h, F, 'o');
xi = linspace(0,12,100);
yi = polyval(p, xi);
plot (xi,yi);

%c
Ffit = polyval(p, h);
Error = sum((F-Ffit).^2)

F7m = polyval(p, 7)
F10m = polyval(p, 10)
F12m = polyval(p, 12)
