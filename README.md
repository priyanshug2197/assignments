Parking Lot Application

functional
create lot 5 (capacity)
    parking lot created
park KA01AB1234 White
    Parked at slot 1
park KA03DE3434 Blue
    Parked at slot 2
park KA04BC6734 White
    Parked at slot 3
leave Slot 2
    Leave KA04BC6734
park KA05VB4567 Yellow
    Parked at slot 2
status
     Slot 1 -> KA01AB1234 Car parked
     Slot 2 -> KA05VB4567 Car parked
     Slot 3 -> KA04BC6734 Car parked
     Slot 4 -> Empty
     Slot 5 -> Empty
color White
    Car with White Color : KA01AB1234, KA04BC6734 (order agnostic)
registration KA04BC6734
    registration KA04BC6734 parked at slot 3

Should be extensible for these future requirements

* Extensive to inclusive of other types of vehicle
* Extensive to inclusive of other like parking stratergy (farthest)
* Input Validation (DTO validator)
* I/O from CLI
* Parking lot is full
* leave slot abc - Invalidate in Validator | Slot number is not present | Slot number not provided
* Parking size is fixed
* In-memory database ( should be extensible)
* Duplicate registration not allowed



