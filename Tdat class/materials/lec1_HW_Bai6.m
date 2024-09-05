clear all;
close all;

x = 0:2/200:2;

u = 2.*log10(6.*x + 1);
v = 3.*cos(6.*x);

plot(x,u,'r');
hold on;
plot(x,v,'b');

axis([0 2 -3 3]);