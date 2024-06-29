% calculate the area and circumference of circles
% print results if the area is greater than 20; print the
% number of circules with area less than 20; terminate on area<=0

N = 0;

radius = input('\nPlease enter a radius: ');
while radius > 0
    area = pi * radius^2;
    circumference = 2 * pi * radius;

    if area > 20
        fprintf('\nRadius = %f units', radius);
        fprintf('\nArea = %f units', area);
        fprintf('\nCircumference = %f units', circumference);
    else
        N = N + 1;
        fprintf('\nThis circle with area less than 20');
    end

    radius = input('\nPlease enter a radius: ');
end

fprintf('\n%d circles with area less than 20', N);




