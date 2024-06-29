% Code 3 Q_2 for-loop

clc, clear, close all

n = input('Enter n: ');
F_n = 0;
f_n = [];

for i=1:n
  F_n = F_n + 1./((i+1).*i);
  f_n = [f_n F_n];
end

plot (f_n, '-.r', 'linewidth', 2, 'markersize', 1)


