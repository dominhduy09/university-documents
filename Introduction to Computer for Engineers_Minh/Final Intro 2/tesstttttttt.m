xdata = [0 0.3000 1.0000 2.3000 3.5000 5.6000 7.5000 8.2000 9.7000];
ydata = [4.9838   49.0727   31.0883   74.4117  107.8540  127.0157  371.8902  542.5732  863.1195];

for degree = 1:6
coef{dgree} = polyfit(xdata, ydata, degree);
xx = 0:0.1:10;
yy = polyval(coef{degree}, xx);
figure(degree)
plot(xdata, ydata, 'o', xx, yy);
drawnow;
yfit=polyval(coef{degree},xdata);
Error_fit(degree)=sum((ydata-yfit).^2);
end
