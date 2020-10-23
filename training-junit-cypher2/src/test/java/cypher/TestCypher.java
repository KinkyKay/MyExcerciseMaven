package cypher;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TestCypher {

	/*
		ABCDEFGHIJKLMNOPQRSTUVWXYZ
	TODO
		encrypt "A", 0 -> A
		encrypt "D", 0 -> D
		encrypt "E", 0 -> E
		encrypt "B", 1 -> C
		//encrypt "C", 2 -> E

	 */

	@Test
	public void testEncryptCypher_A_offset0() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("A", 0)).isEqualTo("A");
	}

		@Test
	public void testEncryptCypher_D_offset0() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("D", 0)).isEqualTo("D");
	}

	@Test
	public void testEncryptCypher_E_offset0() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("E", 0)).isEqualTo("E");
	}



	@Test
	public void testEncryptCypher_B_offset1() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("B", 1)).isEqualTo("C");
	}

	@Test
	public void testEncryptCypher_F_offset1() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("F", 1)).isEqualTo("G");
	}

	@Test
	public void testEncryptCypher_Z_offset1() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("Z", 1)).isEqualTo("A");
	}

	@Test
	public void testEncryptCypher_A_offset1() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("A", 1)).isEqualTo("B");
	}

	@Test
	public void testEncryptCypher_A_offset2() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("A", 2)).isEqualTo("C");
	}

	@Test
	public void testEncryptCypher_Z_offset5() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("Z", 5)).isEqualTo("E");
	}

	@Test
	public void testEncryptCypher_AA_offset0() {
		Encrypter encrypter = new Encrypter();
		assertThat(encrypter.encrypt("AA", 0)).isEqualTo("AA");
	}
}
