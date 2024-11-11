package booknow.exception

class VenueNotFoundException(id: Long) : RuntimeException("Venue with location Id: $id not found")