clc, clear,close all
ftemp = 50;
ctemp = F_to_C_temp (ftemp);
fprintf("%d C equals to %d F", ctemp, ftemp)


scrad = [30 , 40 , 50];
for i=1:length(scrad)

[vol,area] = mathSphere (scrad(i));
fprintf("\n\n For radius: %d", scrad(i))
fprintf("\n For vol: %d", vol)
fprintf("\n For area: %d", area)
end


darray = randn(10e4 , 1);
[mymean , myvar , mystd] = basicStat (darray);
fprintf("\n\n Mean of array: %d", mymean)
fprintf("\n Variance of array: %d", myvar)
fprintf("\n Stadard deviation of array: %d", mystd)


initial_height = 100;
initial_velocity = 20;
time_hit_ground = objhitground (initial_height , initial_velocity);
fprintf("Time to hit ground: %d ", time_hit_ground)


