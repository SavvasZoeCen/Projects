USE HotelDB;

-- 1
SELECT g.name, r.EndDate, rr.RoomNum
FROM `Reservation` r
INNER JOIN `Guest`g ON g.GuestID = r.GuestID
Inner JOIN `RoomReservation` rr ON r.ReservationID = rr.ReservationID
WHERE r.EndDate LIKE '2023-07%';

-- 2
SELECT g.Name, r.RoomNum, res.StartDate, a.Name
FROM `Guest` g
LEFT JOIN `Reservation` res ON g.GuestID = res.GuestID
LEFT JOIN `RoomReservation` rr ON res.ReservationID = rr.ReservationID
LEFT JOIN `Room` r ON r.RoomNum = rr.RoomNum
LEFT JOIN `RoomAmenities` ra ON ra.RoomNum = r.RoomNum
LEFT JOIN `Amenity` a on a.AmenityID = ra.AmenityID
WHERE a.Name LIKE '%jacuzzi%';

-- 3
SELECT g.Name, res.Adults, res.Children, res.StartDate, rr.RoomNum
FROM `Reservation` res
INNER JOIN `Guest` g ON g.GuestID = res.GuestID
INNER JOIN `RoomReservation` rr ON res.ReservationID = rr.ReservationID
WHERE g.Name = 'Zoe Cen';

-- 4
SELECT r.RoomNum, res.ReservationID, res.TotalCost
FROM `RoomReservation` rr
RIGHT JOIN `Room` r ON r.RoomNum = rr.RoomNum
LEFT  JOIN `Reservation` res ON res.ReservationID = rr.ReservationID;

-- 5
SELECT rr.RoomNum
FROM `RoomReservation` rr
INNER JOIN `Reservation` r ON r.ReservationID = rr.ReservationID
WHERE r.Adults + r.Children > 2
AND r.StartDate LIKE '2023-04%';

-- 6
SELECT  g.Name, COUNT(res.ReservationID) resCount
FROM `Reservation` res
LEFT OUTER JOIN `Guest` g ON g.GuestID = res.GuestID
GROUP BY g.Name
ORDER BY COUNT(res.ReservationID) DESC, SUBSTR(g.Name, INSTR(g.Name, ' '));

-- 7
SELECT g.Name, g.Address, g.Phone
FROM `Guest` g
WHERE Phone = '(123) 456-6789';