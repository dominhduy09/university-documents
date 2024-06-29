% Do not include data point V=20
xdata = [0 5 10 15 25];
ydata = [0.001 0.881 2.1637 3.1827 4.961];
degree = 1;
% Linear relationship
coef = polyfit(xdata, ydata, degree);
xx = -5 : 0.5 : 30;
% Range for plotting
yy = polyval(coef, xx);
plot(xdata, ydata, 'o', xx, yy);
resistance = 1 / coef(1) % Output the answe
