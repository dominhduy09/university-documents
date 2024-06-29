clc; clear all; close all;
x_vec = 0:0.1:2;
fx_vec1 = exp(-0.5*x_vec).*sin(5.*x_vec);
fx_vec2 = sin(5.*x_vec);

figure
plot(x_vec,fx_vec1,':bd','LineWidth',2,'MarkerSize',5)
hold on
grid on
plot(x_vec,fx_vec2,'-.r','LineWidth',2,'MarkerSize',2)
xlabel('x')
ylabel('f(x)')
title('Plot f_1(x) and f_2(x)')
legend('f_1(x)','f_2(x)')