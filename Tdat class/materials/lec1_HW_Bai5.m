clear all;
close all;

t = 1:(4/40):5;

T = 6.*log(t)-7.*exp((-0.2).*t);
plot(t,T);

title('Temperature versus Time');
xlabel('Time in Minutes');
ylabel('Temperature in Celcius');