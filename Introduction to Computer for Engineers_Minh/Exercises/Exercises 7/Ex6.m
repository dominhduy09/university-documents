% Prompt the user to enter the length and the unit
lengthValue = input('Enter the length value: ');
unit = input('Enter the unit (mm, cm, in, or inch): ', 's');

% Convert length to millimeters based on the input unit
if strcmpi(unit, 'mm')
    convertedLength = lengthValue;
    unitString = 'millimeters';
elseif strcmpi(unit, 'cm')
    convertedLength = lengthValue * 10;
    unitString = 'millimeters';
elseif strcmpi(unit, 'in') || strcmpi(unit, 'inch')
    convertedLength = lengthValue * 25.4;
    unitString = 'millimeters';
else
    error('Invalid unit specified.');
end

% Display conversion result
fprintf('Converted %.2f %s to %.2f %s.\n', lengthValue, unit, convertedLength, unitString);

