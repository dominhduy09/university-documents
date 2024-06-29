% Code 3 Q_2 while-loop

clc, clear, close all

n = input('Enter n: ');
F_n = 0;
f_n = [];
i=1;

while i < n+1
  F_n = F_n + 1./((i+1).*i);
  f_n = [f_n F_n];
  i = i+1;
end
plot (f_n, '-.r', 'linewidth', 2, 'markersize', 1)


