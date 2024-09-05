% Bài 1.4 using subplot
clear all;
close all;


A = 2;
x = 0:0.01:1;

subplot(2,1,1);
y = A.*sin(2.*pi.*10.*x);
plot(x,y);
title('Sine Wave');
xlabel('Time(Second)');
ylabel('Amplitude');

subplot(2,1,2);
z = A.*cos(2.*pi.*5.*x);
plot(x,z,'r');
title('Cosine Wave');
xlabel('Time(Second)');
ylabel('Amplitude');

