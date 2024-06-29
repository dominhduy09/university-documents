% Code 3 Q_1

clc, clear, close all

x = -2:0.01:4;
f_x = [];

for q= 1:length(x)
  if x(q) < 0
    f_x = [f_x -x(q)]; % -x
  elseif x(q) <= 3
    f_x = [f_x 1]; % 1
  else
    f_x = [f_x 2*x(q)]; % 2*x
  endif
end

plot (x, f_x , 'g', 'linewidth', 2,'markersize', 1 )
