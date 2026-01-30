package oving2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VehicleTest {

	private Vehicle vehicle;

	private static void checkVehicleState(char vehicleType, char fuelType,
			String registrationNumber, Vehicle vehicle) {
		assertEquals(vehicleType, vehicle.getVehicleType());
		assertEquals(fuelType, vehicle.getFuelType());
		assertEquals(registrationNumber, vehicle.getRegistrationNumber());
	}

	private static void checkInvalidConstructor(char vehicleType, char fuelType,
			String registrationNumber) {
		assertThrows(IllegalArgumentException.class, () -> {
			new Vehicle(vehicleType, fuelType, registrationNumber);
		});
	}

	private static void checkInvalidsetRegistration(Vehicle vehicle, String originalRegNum,
			String newRegNum) {
		assertThrows(IllegalArgumentException.class, () -> {
			vehicle.setRegistrationNumber(newRegNum);
		});

		assertEquals(originalRegNum, vehicle.getRegistrationNumber());
	}

	@Test
	@DisplayName("Private fields")
	public void testPrivateFields() {
		TestHelper.checkIfFieldsPrivate(Vehicle.class);
	}

	@Test
	public void testConstructor() {
		vehicle = new Vehicle('C', 'D', "BN12345");
		VehicleTest.checkVehicleState('C', 'D', "BN12345", vehicle);

		vehicle = new Vehicle('M', 'E', "EL1234");
		VehicleTest.checkVehicleState('M', 'E', "EL1234", vehicle);
		VehicleTest.checkInvalidConstructor('C', 'D', null);
		VehicleTest.checkInvalidConstructor('C', 'Y', "BN12345");
		VehicleTest.checkInvalidConstructor('M', 'H', "HY1234");
		VehicleTest.checkInvalidConstructor('P', 'D', "BN12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "A1234");
		VehicleTest.checkInvalidConstructor('C', 'G', "A12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "A123456");
		VehicleTest.checkInvalidConstructor('C', 'G', "A12344");
		VehicleTest.checkInvalidConstructor('C', 'G', "AÆ12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "ab12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "A12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "A1B12345");
		VehicleTest.checkInvalidConstructor('M', 'G', "A1234");
		VehicleTest.checkInvalidConstructor('M', 'G', "A12345");
		VehicleTest.checkInvalidConstructor('M', 'G', "A123");
		VehicleTest.checkInvalidConstructor('M', 'G', "AB12345");
		VehicleTest.checkInvalidConstructor('M', 'G', "ABC1234");
		VehicleTest.checkInvalidConstructor('M', 'G', "ABC12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "AÅ1234");
		VehicleTest.checkInvalidConstructor('C', 'G', "ab1234");
		VehicleTest.checkInvalidConstructor('C', 'G', "EL12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "EK12345");
		VehicleTest.checkInvalidConstructor('C', 'G', "HY12345");
		VehicleTest.checkInvalidConstructor('C', 'D', "EL12345");
		VehicleTest.checkInvalidConstructor('C', 'D', "EK12345");
		VehicleTest.checkInvalidConstructor('C', 'D', "HY12345");
		VehicleTest.checkInvalidConstructor('C', 'H', "EL12345");
		VehicleTest.checkInvalidConstructor('C', 'H', "EK12345");
		VehicleTest.checkInvalidConstructor('C', 'H', "BN12345");
		VehicleTest.checkInvalidConstructor('C', 'E', "HY12345");
		VehicleTest.checkInvalidConstructor('C', 'E', "BN12345");
		VehicleTest.checkInvalidConstructor('M', 'G', "EL1234");
		VehicleTest.checkInvalidConstructor('M', 'G', "EK1234");
		VehicleTest.checkInvalidConstructor('M', 'G', "HY1234");
		VehicleTest.checkInvalidConstructor('M', 'D', "EL1234");
		VehicleTest.checkInvalidConstructor('M', 'D', "EK1234");
		VehicleTest.checkInvalidConstructor('M', 'D', "HY1234");
		VehicleTest.checkInvalidConstructor('M', 'E', "HY1234");
		VehicleTest.checkInvalidConstructor('M', 'E', "BN1234");
	}

	@Test
	public void testSetRegistrationNumber() {
		vehicle = new Vehicle('C', 'D', "BN12345");
		vehicle.setRegistrationNumber("AB54321");
		VehicleTest.checkVehicleState('C', 'D', "AB54321", vehicle);

		vehicle = new Vehicle('M', 'E', "EK1234");
		vehicle.setRegistrationNumber("EL4321");
		VehicleTest.checkVehicleState('M', 'E', "EL4321", vehicle);

		vehicle = new Vehicle('C', 'D', "BN12345");

		assertThrows(IllegalArgumentException.class, () -> {
			vehicle.setRegistrationNumber("AB654321");
		});

		VehicleTest.checkVehicleState('C', 'D', "BN12345", vehicle);

		vehicle = new Vehicle('M', 'E', "EL1234");

		assertThrows(IllegalArgumentException.class, () -> {
			vehicle.setRegistrationNumber("HY1234");
		});

		VehicleTest.checkVehicleState('M', 'E', "EL1234", vehicle);

		vehicle = new Vehicle('C', 'G', "AB12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"AB123456");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"ABC1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"AÆ12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"ab12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"A1B2345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"AB123456");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"ABC1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"AÆ12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"ab12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"A1B2345");

		vehicle = new Vehicle('M', 'G', "AB1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "A12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AB123");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"AB12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"ABC1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"ABC12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "AÅ1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "ab1234");

		vehicle = new Vehicle('C', 'G', "AB12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"EL12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"EK12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"HY12345");

		vehicle = new Vehicle('C', 'D', "AB12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"EL12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"EK12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"HY12345");

		vehicle = new Vehicle('C', 'H', "HY12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"EL12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"EK12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"BN12345");

		vehicle = new Vehicle('C', 'E', "EL12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"HY12345");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(),
				"BN12345");

		vehicle = new Vehicle('M', 'G', "AB1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY1234");

		vehicle = new Vehicle('M', 'D', "AB1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EL1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "EK1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY1234");

		vehicle = new Vehicle('M', 'E', "EK1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "HY1234");
		VehicleTest.checkInvalidsetRegistration(vehicle, vehicle.getRegistrationNumber(), "BN1234");
	}
}
