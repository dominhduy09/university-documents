% calculate the area and circumference of 10 circles
% print it out if the area is greater than 20

N = 0;

for i = 1:10
  radius = input('\n Enter radius: ');
  radius = abs(radius);

  area = radius * radius * pi;
  circumference = 2 * radius * pi;

  if area > 20
    fprintf('\n Radius = %f units', radius);
    fprintf('\n Area = %f units', area);
    fprintf('\n Circumference = %f units', circumference);
  else
    N = N + 1;
    fprintf('This circle with area less than 20');
  endif
 end

 fprintf('\n %f circles with area less than 20', N);

