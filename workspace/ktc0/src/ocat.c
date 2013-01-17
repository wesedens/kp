
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// test comment please ignore

int main(int argc, char *argv[])
{
	unsigned char buffer[256];
	size_t        offset      = 0;
	size_t        bytes_read  = sizeof(buffer);
	size_t        bytes_write = 0;
	unsigned char byte_offset = 0;
	int           i           = 0;

	if (argc < 1 || argc > 2){
		printf("<usage>: %s [num_offset]\n", argv[0]);
		return -1;
	}

	if (argc == 2){
		byte_offset = (unsigned char)atoi(argv[1]);
	}

	while (bytes_read == sizeof(buffer)) {
		bytes_read = read(STDIN_FILENO, buffer, sizeof(buffer));

		for(i=0; i<sizeof(buffer); ++i){
			buffer[i] = buffer[i] + byte_offset;
		}
		bytes_write = write(STDOUT_FILENO, buffer, bytes_read);
		offset += bytes_read;
	}

	return 0;
}
